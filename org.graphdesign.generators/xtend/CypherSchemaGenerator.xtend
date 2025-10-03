/**************************************************************
 * CypherSchemaGenerator.xtend
 * 
 * Generates Cypher schema (constraints, indexes, relationship 
 * documentation) from a QDGLDM model instance.
 * 
 * Part of GraphDesign project.
 **************************************************************/

package org.graphdesign.generators.xtend

import org.graphdesign.qdgldm.QDGLDMModel
import org.graphdesign.qdgldm.NodeLabel
import org.graphdesign.qdgldm.Property
import org.graphdesign.qdgldm.RelationshipType
import org.graphdesign.qdgldm.Index

class CypherSchemaGenerator {
    
    /**
     * Main entrypoint: generates Cypher schema code.
     */
    def generate(QDGLDMModel model) '''
        // ============================================================
        // Generated Cypher Schema for «model.nodeLabels.size» NodeLabels,
        // «model.relationshipTypes.size» RelationshipTypes,
        // and «model.indexes.size» Indexes
        // ============================================================

        // -----------------------------
        // Constraints (Unique IDs)
        // -----------------------------
        «FOR n : model.nodeLabels»
            «generateConstraint(n)»
        «ENDFOR»

        // -----------------------------
        // Relationships (Documentation only)
        // -----------------------------
        «FOR r : model.relationshipTypes»
            «generateRelationshipDoc(r)»
        «ENDFOR»

        // -----------------------------
        // Indexes
        // -----------------------------
        «FOR idx : model.indexes»
            «generateIndex(idx)»
        «ENDFOR»
    '''

    /**
     * Generate constraint for a NodeLabel if it has a unique property.
     */
    def generateConstraint(NodeLabel n) {
        val pk = n.properties.findFirst[p | p.indexed || p.name.toLowerCase.contains("id") || p.name.toLowerCase.contains("login") || p.name.toLowerCase.contains("oid")]
        if (pk !== null)
            '''CREATE CONSTRAINT unique_«n.name.toLowerCase()»
               IF NOT EXISTS
               FOR (n:«n.name»)
               REQUIRE n.«pk.name» IS UNIQUE;'''
        else
            "// No unique constraint detected for " + n.name
    }

    /**
     * Generate documentation for a RelationshipType.
     */
    def generateRelationshipDoc(RelationshipType r) '''
        // Relationship: «r.name»
        //   Source: «r.source?.name» («r.sourceMultiplicity»)
        //   Target: «r.target?.name» («r.targetMultiplicity»)
        //   Kind:   «r.kind»
        «IF !r.properties.empty»
            //   Properties:
            «FOR p : r.properties»
                //     - «p.name» : «p.type»
            «ENDFOR»
        «ENDIF»
    '''

    /**
     * Generate index creation statements.
     */
    def generateIndex(Index idx) {
        if (idx.properties.size > 1)
            '''CREATE INDEX «idx.indexName»
               IF NOT EXISTS FOR (n:«idx.nodeName»)
               ON ( «FOR p : idx.properties SEPARATOR ", "»n.«p.name»«ENDFOR» );'''
        else
            '''CREATE INDEX «idx.indexName»
               IF NOT EXISTS FOR (n:«idx.nodeName»)
               ON (n.«idx.properties.head.name»);'''
    }
}
