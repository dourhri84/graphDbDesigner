package org.graphdesign.dqrm.impl;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.graphdesign.dqrm.*;

/**
 * Implementation of the DQRM Package.
 */
public class DQRMPackageImpl extends EPackageImpl implements DQRMPackage {
    private EClass dqrmModelEClass = null;
    private EClass nodeLabelEClass = null;
    private EClass propertyEClass = null;
    private EClass relationshipTypeEClass = null;
    private EClass functionalReqEClass = null;
    private EClass queryDeclEClass = null;

    private static boolean isInited = false;

    private DQRMPackageImpl() {
        super(eNS_URI, DQRMFactory.eINSTANCE);
    }

    public static DQRMPackage init() {
        if (isInited) return (DQRMPackage)EPackage.Registry.INSTANCE.getEPackage(DQRMPackage.eNS_URI);
        DQRMPackageImpl thePackage = new DQRMPackageImpl();
        isInited = true;

        thePackage.createPackageContents();
        thePackage.initializePackageContents();
        EPackage.Registry.INSTANCE.put(DQRMPackage.eNS_URI, thePackage);
        return thePackage;
    }

    private boolean isCreated = false;

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        dqrmModelEClass = createEClass(DQRM_MODEL);
        createEAttribute(dqrmModelEClass, DQRM_MODEL__NAME);
        createEReference(dqrmModelEClass, DQRM_MODEL__NODELABELS);
        createEReference(dqrmModelEClass, DQRM_MODEL__RELATIONSHIPTYPES);
        createEReference(dqrmModelEClass, DQRM_MODEL__FUNCTIONALREQ);

        nodeLabelEClass = createEClass(NODELABEL);
        createEAttribute(nodeLabelEClass, NODELABEL__NAME);
        createEReference(nodeLabelEClass, NODELABEL__PROPERTIES);

        propertyEClass = createEClass(PROPERTY);
        createEAttribute(propertyEClass, PROPERTY__NAME);
        createEAttribute(propertyEClass, PROPERTY__TYPE);
        createEAttribute(propertyEClass, PROPERTY__UNIQUE);

        relationshipTypeEClass = createEClass(RELATIONSHIPTYPE);
        createEAttribute(relationshipTypeEClass, RELATIONSHIPTYPE__NAME);
        createEReference(relationshipTypeEClass, RELATIONSHIPTYPE__SOURCE);
        createEReference(relationshipTypeEClass, RELATIONSHIPTYPE__TARGET);
        createEReference(relationshipTypeEClass, RELATIONSHIPTYPE__PROPERTIES);
        createEAttribute(relationshipTypeEClass, RELATIONSHIPTYPE__KIND);

        functionalReqEClass = createEClass(FUNCTIONALREQ);
        createEAttribute(functionalReqEClass, FUNCTIONALREQ__APPNAME);
        createEReference(functionalReqEClass, FUNCTIONALREQ__QUERIES);

        queryDeclEClass = createEClass(QUERYDECL);
        createEAttribute(queryDeclEClass, QUERYDECL__NAME);
        createEAttribute(queryDeclEClass, QUERYDECL__BODY);
    }

    private boolean isInitialized = false;

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(dqrmModelEClass, DQRMModel.class, "DQRMModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDQRMModel_Name(), ecorePackage.getEString(), "name", null, 1, 1, DQRMModel.class, IS_CHANGEABLE, IS_ORDERED);
        initEReference(getDQRMModel_NodeLabels(), this.getNodeLabel(), null, "nodeLabels", null, 0, -1, DQRMModel.class, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_ORDERED);
        initEReference(getDQRMModel_RelationshipTypes(), this.getRelationshipType(), null, "relationshipTypes", null, 0, -1, DQRMModel.class, IS_COMPOSITE, IS_ORDERED);
        initEReference(getDQRMModel_FunctionalReq(), this.getFunctionalReq(), null, "functionalReq", null, 0, 1, DQRMModel.class, IS_COMPOSITE, IS_ORDERED);

        initEClass(nodeLabelEClass, NodeLabel.class, "NodeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNodeLabel_Name(), ecorePackage.getEString(), "name", null, 1, 1, NodeLabel.class, IS_CHANGEABLE, IS_ORDERED);
        initEReference(getNodeLabel_Properties(), this.getProperty(), null, "properties", null, 0, -1, NodeLabel.class, IS_COMPOSITE, IS_ORDERED);

        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, IS_CHANGEABLE, IS_ORDERED);
        initEAttribute(getProperty_Type(), ecorePackage.getEString(), "type", null, 1, 1, Property.class, IS_CHANGEABLE, IS_ORDERED);
        initEAttribute(getProperty_Unique(), ecorePackage.getEBoolean(), "unique", "false", 0, 1, Property.class, IS_CHANGEABLE, IS_ORDERED);

        initEClass(relationshipTypeEClass, RelationshipType.class, "RelationshipType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRelationshipType_Name(), ecorePackage.getEString(), "name", null, 1, 1, RelationshipType.class, IS_CHANGEABLE, IS_ORDERED);
        initEReference(getRelationshipType_Source(), this.getNodeLabel(), null, "source", null, 1, 1, RelationshipType.class, IS_RESOLVE_PROXIES, IS_ORDERED);
        initEReference(getRelationshipType_Target(), this.getNodeLabel(), null, "target", null, 1, 1, RelationshipType.class, IS_RESOLVE_PROXIES, IS_ORDERED);
        initEReference(getRelationshipType_Properties(), this.getProperty(), null, "properties", null, 0, -1, RelationshipType.class, IS_COMPOSITE, IS_ORDERED);
        initEAttribute(getRelationshipType_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, RelationshipType.class, IS_CHANGEABLE, IS_ORDERED);

        initEClass(functionalReqEClass, FunctionalReq.class, "FunctionalReq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFunctionalReq_Appname(), ecorePackage.getEString(), "appname", null, 1, 1, FunctionalReq.class, IS_CHANGEABLE, IS_ORDERED);
        initEReference(getFunctionalReq_Queries(), this.getQueryDecl(), null, "queries", null, 0, -1, FunctionalReq.class, IS_COMPOSITE, IS_ORDERED);

        initEClass(queryDeclEClass, QueryDecl.class, "QueryDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQueryDecl_Name(), ecorePackage.getEString(), "name", null, 1, 1, QueryDecl.class, IS_CHANGEABLE, IS_ORDERED);
        initEAttribute(getQueryDecl_Body(), ecorePackage.getEString(), "body", null, 1, 1, QueryDecl.class, IS_CHANGEABLE, IS_ORDERED);

        createResource(eNS_URI);
    }
}
