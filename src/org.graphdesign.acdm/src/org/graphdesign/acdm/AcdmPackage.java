package org.graphdesign.acdm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * The Package for the ACDM model.
 * It contains accessors for the meta objects to represent each class and feature.
 */
public interface ACDMPackage extends EPackage {
    String eNAME = "acdm";
    String eNS_URI = "http://www.graphdesign.org/acdm/1.0";
    String eNS_PREFIX = "acdm";

    ACDMPackage eINSTANCE = org.graphdesign.acdm.impl.ACDMPackageImpl.init();

    // -------------------------
    // Meta object IDs
    // -------------------------

    int ACDMCLASS = 0;
    int ACDMATTRIBUTE = 1;
    int ACDMASSOCIATION = 2;

    // Features of ACDMClass
    int ACDMCLASS__NAME = 0;
    int ACDMCLASS__ATTRIBUTES = 1;

    // Features of ACDMAttribute
    int ACDMATTRIBUTE__NAME = 0;
    int ACDMATTRIBUTE__TYPE = 1;

    // Features of ACDMAssociation
    int ACDMASSOCIATION__END1 = 0;
    int ACDMASSOCIATION__END2 = 1;

    // -------------------------
    // Accessors for meta objects
    // -------------------------

    EClass getACDMClass();
    EAttribute getACDMClass_Name();
    EReference getACDMClass_Attributes();

    EClass getACDMAttribute();
    EAttribute getACDMAttribute_Name();
    EAttribute getACDMAttribute_Type();

    EClass getACDMAssociation();
    EReference getACDMAssociation_End1();
    EReference getACDMAssociation_End2();

    ACDMFactory getACDMFactory();

    // -------------------------
    // Literals for quick access
    // -------------------------
    interface Literals {
        EClass ACDMCLASS = eINSTANCE.getACDMClass();
        EAttribute ACDMCLASS__NAME = eINSTANCE.getACDMClass_Name();
        EReference ACDMCLASS__ATTRIBUTES = eINSTANCE.getACDMClass_Attributes();

        EClass ACDMATTRIBUTE = eINSTANCE.getACDMAttribute();
        EAttribute ACDMATTRIBUTE__NAME = eINSTANCE.getACDMAttribute_Name();
        EAttribute ACDMATTRIBUTE__TYPE = eINSTANCE.getACDMAttribute_Type();

        EClass ACDMASSOCIATION = eINSTANCE.getACDMAssociation();
        EReference ACDMASSOCIATION__END1 = eINSTANCE.getACDMAssociation_End1();
        EReference ACDMASSOCIATION__END2 = eINSTANCE.getACDMAssociation_End2();
    }
}
