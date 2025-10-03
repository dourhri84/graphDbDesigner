package org.graphdesign.dqrm;

import org.eclipse.emf.ecore.*;

/**
 * The Package for the DQRM model.
 * Defines constants and meta object accessors.
 */
public interface DQRMPackage extends EPackage {
    String eNAME = "dqrm";
    String eNS_URI = "http://www.graphdesign.org/dqrm/1.0";
    String eNS_PREFIX = "dqrm";

    DQRMPackage eINSTANCE = org.graphdesign.dqrm.impl.DQRMPackageImpl.init();

    // -------------------------
    // Meta object IDs
    // -------------------------
    int DQRM_MODEL = 0;
    int NODELABEL = 1;
    int PROPERTY = 2;
    int RELATIONSHIPTYPE = 3;
    int FUNCTIONALREQ = 4;
    int QUERYDECL = 5;

    // ---- DQRMModel features ----
    int DQRM_MODEL__NAME = 0;
    int DQRM_MODEL__NODELABELS = 1;
    int DQRM_MODEL__RELATIONSHIPTYPES = 2;
    int DQRM_MODEL__FUNCTIONALREQ = 3;

    // ---- NodeLabel ----
    int NODELABEL__NAME = 0;
    int NODELABEL__PROPERTIES = 1;

    // ---- Property ----
    int PROPERTY__NAME = 0;
    int PROPERTY__TYPE = 1;
    int PROPERTY__UNIQUE = 2;

    // ---- RelationshipType ----
    int RELATIONSHIPTYPE__NAME = 0;
    int RELATIONSHIPTYPE__SOURCE = 1;
    int RELATIONSHIPTYPE__TARGET = 2;
    int RELATIONSHIPTYPE__PROPERTIES = 3;
    int RELATIONSHIPTYPE__KIND = 4;

    // ---- FunctionalReq ----
    int FUNCTIONALREQ__APPNAME = 0;
    int FUNCTIONALREQ__QUERIES = 1;

    // ---- QueryDecl ----
    int QUERYDECL__NAME = 0;
    int QUERYDECL__BODY = 1;

    // -------------------------
    // Accessors
    // -------------------------
    EClass getDQRMModel();
    EAttribute getDQRMModel_Name();
    EReference getDQRMModel_NodeLabels();
    EReference getDQRMModel_RelationshipTypes();
    EReference getDQRMModel_FunctionalReq();

    EClass getNodeLabel();
    EAttribute getNodeLabel_Name();
    EReference getNodeLabel_Properties();

    EClass getProperty();
    EAttribute getProperty_Name();
    EAttribute getProperty_Type();
    EAttribute getProperty_Unique();

    EClass getRelationshipType();
    EAttribute getRelationshipType_Name();
    EReference getRelationshipType_Source();
    EReference getRelationshipType_Target();
    EReference getRelationshipType_Properties();
    EAttribute getRelationshipType_Kind();

    EClass getFunctionalReq();
    EAttribute getFunctionalReq_Appname();
    EReference getFunctionalReq_Queries();

    EClass getQueryDecl();
    EAttribute getQueryDecl_Name();
    EAttribute getQueryDecl_Body();

    DQRMFactory getDQRMFactory();

    // -------------------------
    // Literals
    // -------------------------
    interface Literals {
        EClass DQRM_MODEL = eINSTANCE.getDQRMModel();
        EClass NODELABEL = eINSTANCE.getNodeLabel();
        EClass PROPERTY = eINSTANCE.getProperty();
        EClass RELATIONSHIPTYPE = eINSTANCE.getRelationshipType();
        EClass FUNCTIONALREQ = eINSTANCE.getFunctionalReq();
        EClass QUERYDECL = eINSTANCE.getQueryDecl();
    }
}
