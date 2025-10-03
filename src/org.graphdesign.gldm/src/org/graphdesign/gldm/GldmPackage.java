package org.graphdesign.gldm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * The Package for the GLDM model.
 * It defines constants and accessors for the meta objects.
 */
public interface GLDMPackage extends EPackage {
    String eNAME = "gldm";
    String eNS_URI = "http://www.graphdesign.org/gldm/1.0";
    String eNS_PREFIX = "gldm";

    GLDMPackage eINSTANCE = org.graphdesign.gldm.impl.GLDMPackageImpl.init();

    // -------------------------
    // Meta object IDs
    // -------------------------

    int NODELABEL = 0;
    int PROPERTY = 1;
    int RELATIONSHIPTYPE = 2;

    // Features of NodeLabel
    int NODELABEL__NAME = 0;
    int NODELABEL__PROPERTIES = 1;

    // Features of Property
    int PROPERTY__NAME = 0;
    int PROPERTY__TYPE = 1;
    int PROPERTY__UNIQUE = 2;

    // Features of RelationshipType
    int RELATIONSHIPTYPE__NAME = 0;
    int RELATIONSHIPTYPE__SOURCE = 1;
    int RELATIONSHIPTYPE__TARGET = 2;
    int RELATIONSHIPTYPE__PROPERTIES = 3;
    int RELATIONSHIPTYPE__KIND = 4;

    // -------------------------
    // Accessors for meta objects
    // -------------------------

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

    GLDMFactory getGLDMFactory();

    // -------------------------
    // Literals
    // -------------------------
    interface Literals {
        EClass NODELABEL = eINSTANCE.getNodeLabel();
        EAttribute NODELABEL__NAME = eINSTANCE.getNodeLabel_Name();
        EReference NODELABEL__PROPERTIES = eINSTANCE.getNodeLabel_Properties();

        EClass PROPERTY = eINSTANCE.getProperty();
        EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();
        EAttribute PROPERTY__TYPE = eINSTANCE.getProperty_Type();
        EAttribute PROPERTY__UNIQUE = eINSTANCE.getProperty_Unique();

        EClass RELATIONSHIPTYPE = eINSTANCE.getRelationshipType();
        EAttribute RELATIONSHIPTYPE__NAME = eINSTANCE.getRelationshipType_Name();
        EReference RELATIONSHIPTYPE__SOURCE = eINSTANCE.getRelationshipType_Source();
        EReference RELATIONSHIPTYPE__TARGET = eINSTANCE.getRelationshipType_Target();
        EReference RELATIONSHIPTYPE__PROPERTIES = eINSTANCE.getRelationshipType_Properties();
        EAttribute RELATIONSHIPTYPE__KIND = eINSTANCE.getRelationshipType_Kind();
    }
}
