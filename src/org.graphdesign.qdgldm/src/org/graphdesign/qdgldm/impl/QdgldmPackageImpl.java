package org.graphdesign.qdgldm.impl;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.graphdesign.qdgldm.*;

/**
 * Implementation of the QDGLDM Package.
 */
public class QDGLDMPackageImpl extends EPackageImpl implements QDGLDMPackage {
    private EClass qdgldmModelEClass = null;
    private EClass nodeLabelEClass = null;
    private EClass propertyEClass = null;
    private EClass relationshipTypeEClass = null;
    private EClass indexEClass = null;

    private static boolean isInited = false;

    private QDGLDMPackageImpl() {
        super(eNS_URI, QDGLDMFactory.eINSTANCE);
    }

    public static QDGLDMPackage init() {
        if (isInited) return (QDGLDMPackage)EPackage.Registry.INSTANCE.getEPackage(QDGLDMPackage.eNS_URI);
        QDGLDMPackageImpl thePackage = new QDGLDMPackageImpl();
        isInited = true;

        thePackage.createPackageContents();
        thePackage.initializePackageContents();
        EPackage.Registry.INSTANCE.put(QDGLDMPackage.eNS_URI, thePackage);
        return thePackage;
    }

    private boolean isCreated = false;

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        qdgldmModelEClass = createEClass(QDGLDM_MODEL);
        createEReference(qdgldmModelEClass, QDGLDM_MODEL__NODELABELS);
        createEReference(qdgldmModelEClass, QDGLDM_MODEL__RELATIONSHIPTYPES);
        createEReference(qdgldmModelEClass, QDGLDM_MODEL__INDEXES);

        nodeLabelEClass = createEClass(NODELABEL);
        createEAttribute(nodeLabelEClass, NODELABEL__NAME);
        createEReference(nodeLabelEClass, NODELABEL__PROPERTIES);

        propertyEClass = createEClass(PROPERTY);
        createEAttribute(propertyEClass, PROPERTY__NAME);
        createEAttribute(propertyEClass, PROPERTY__TYPE);
        createEAttribute(propertyEClass, PROPERTY__INDEXED);

        relationshipTypeEClass = createEClass(RELATIONSHIPTYPE);
        createEAttribute(relationshipTypeEClass, RELATIONSHIPTYPE__NAME);
        createEReference(relationshipTypeEClass, RELATIONSHIPTYPE__SOURCE);
        createEReference(relationshipTypeEClass, RELATIONSHIPTYPE__TARGET);
        createEReference(relationshipTypeEClass, RELATIONSHIPTYPE__PROPERTIES);
        createEAttribute(relationshipTypeEClass, RELATIONSHIPTYPE__KIND);

        indexEClass = createEClass(INDEX);
        createEAttribute(indexEClass, INDEX__INDEXNAME);
        createEAttribute(indexEClass, INDEX__NODENAME);
        createEReference(indexEClass, INDEX__PROPERTIES);
    }

    private boolean isInitialized = false;

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // ---- QDGLDMModel ----
        initEClass(qdgldmModelEClass, QDGLDMModel.class, "QDGLDMModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getQDGLDMModel_NodeLabels(), this.getNodeLabel(), null, "nodeLabels", null, 0, -1, QDGLDMModel.class, IS_COMPOSITE, IS_ORDERED);
        initEReference(getQDGLDMModel_RelationshipTypes(), this.getRelationshipType(), null, "relationshipTypes", null, 0, -1, QDGLDMModel.class, IS_COMPOSITE, IS_ORDERED);
        initEReference(getQDGLDMModel_Indexes(), this.getIndex(), null, "indexes", null, 0, -1, QDGLDMModel.class, IS_COMPOSITE, IS_ORDERED);

        // ---- NodeLabel ----
        initEClass(nodeLabelEClass, NodeLabel.class, "NodeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNodeLabel_Name(), ecorePackage.getEString(), "name", null, 1, 1, NodeLabel.class, IS_CHANGEABLE, IS_ORDERED);
        initEReference(getNodeLabel_Properties(), this.getProperty(), null, "properties", null, 0, -1, NodeLabel.class, IS_COMPOSITE, IS_ORDERED);

        // ---- Property ----
        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, IS_CHANGEABLE, IS_ORDERED);
        initEAttribute(getProperty_Type(), ecorePackage.getEString(), "type", null, 1, 1, Property.class, IS_CHANGEABLE, IS_ORDERED);
        initEAttribute(getProperty_Indexed(), ecorePackage.getEBoolean(), "indexed", "false", 0, 1, Property.class, IS_CHANGEABLE, IS_ORDERED);

        // ---- RelationshipType ----
        initEClass(relationshipTypeEClass, RelationshipType.class, "RelationshipType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRelationshipType_Name(), ecorePackage.getEString(), "name", null, 1, 1, RelationshipType.class, IS_CHANGEABLE, IS_ORDERED);
        initEReference(getRelationshipType_Source(), this.getNodeLabel(), null, "source", null, 1, 1, RelationshipType.class, IS_RESOLVE_PROXIES, IS_ORDERED);
        initEReference(getRelationshipType_Target(), this.getNodeLabel(), null, "target", null, 1, 1, RelationshipType.class, IS_RESOLVE_PROXIES, IS_ORDERED);
        initEReference(getRelationshipType_Properties(), this.getProperty(), null, "properties", null, 0, -1, RelationshipType.class, IS_COMPOSITE, IS_ORDERED);
        initEAttribute(getRelationshipType_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, RelationshipType.class, IS_CHANGEABLE, IS_ORDERED);

        // ---- Index ----
        initEClass(indexEClass, Index.class, "Index", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIndex_IndexName(), ecorePackage.getEString(), "indexName", null, 1, 1, Index.class, IS_CHANGEABLE, IS_ORDERED);
        initEAttribute(getIndex_NodeName(), ecorePackage.getEString(), "nodeName", null, 1, 1, Index.class, IS_CHANGEABLE, IS_ORDERED);
        initEReference(getIndex_Properties(), this.getProperty(), null, "properties", null, 1, -1, Index.class, IS_COMPOSITE, IS_ORDERED);

        createResource(eNS_URI);
    }
}
