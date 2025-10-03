package org.graphdesign.qdgldm;

import org.eclipse.emf.ecore.EFactory;

/**
 * The Factory for the QDGLDM model.
 * Provides a create method for each non-abstract class of the model.
 */
public interface QDGLDMFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     */
    QDGLDMFactory eINSTANCE = org.graphdesign.qdgldm.impl.QDGLDMFactoryImpl.init();

    QDGLDMModel createQDGLDMModel();
    NodeLabel createNodeLabel();
    Property createProperty();
    RelationshipType createRelationshipType();
    Index createIndex();

    QDGLDMPackage getQDGLDMPackage();
}
