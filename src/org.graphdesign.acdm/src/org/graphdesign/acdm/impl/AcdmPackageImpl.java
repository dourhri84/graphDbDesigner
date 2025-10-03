package org.graphdesign.acdm.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.graphdesign.acdm.*;

/**
 * Implementation of the ACDM Package.
 */
public class ACDMPackageImpl extends EPackageImpl implements ACDMPackage {
    private EClass acdmClassEClass = null;
    private EClass acdmAttributeEClass = null;
    private EClass acdmAssociationEClass = null;

    private static boolean isInited = false;

    private ACDMPackageImpl() {
        super(eNS_URI, ACDMFactory.eINSTANCE);
    }

    public static ACDMPackage init() {
        if (isInited) return (ACDMPackage)EPackage.Registry.INSTANCE.getEPackage(ACDMPackage.eNS_URI);
        ACDMPackageImpl theACDMPackage = new ACDMPackageImpl();
        isInited = true;

        theACDMPackage.createPackageContents();
        theACDMPackage.initializePackageContents();
        EPackage.Registry.INSTANCE.put(ACDMPackage.eNS_URI, theACDMPackage);
        return theACDMPackage;
    }

    private boolean isCreated = false;

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        acdmClassEClass = createEClass(ACDMCLASS);
        createEAttribute(acdmClassEClass, ACDMCLASS__NAME);
        createEReference(acdmClassEClass, ACDMCLASS__ATTRIBUTES);

        acdmAttributeEClass = createEClass(ACDMATTRIBUTE);
        createEAttribute(acdmAttributeEClass, ACDMATTRIBUTE__NAME);
        createEAttribute(acdmAttributeEClass, ACDMATTRIBUTE__TYPE);

        acdmAssociationEClass = createEClass(ACDMASSOCIATION);
        createEReference(acdmAssociationEClass, ACDMASSOCIATION__END1);
        createEReference(acdmAssociationEClass, ACDMASSOCIATION__END2);
    }

    private boolean isInitialized = false;

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(acdmClassEClass, ACDMClass.class, "ACDMClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getACDMClass_Name(), ecorePackage.getEString(), "name", null, 1, 1, ACDMClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getACDMClass_Attributes(), this.getACDMAttribute(), null, "attributes", null, 0, -1, ACDMClass.class, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNIQUE, IS_ORDERED);

        initEClass(acdmAttributeEClass, ACDMAttribute.class, "ACDMAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getACDMAttribute_Name(), ecorePackage.getEString(), "name", null, 1, 1, ACDMAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_ORDERED);
        initEAttribute(getACDMAttribute_Type(), ecorePackage.getEString(), "type", null, 1, 1, ACDMAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_ORDERED);

        initEClass(acdmAssociationEClass, ACDMAssociation.class, "ACDMAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getACDMAssociation_End1(), this.getACDMClass(), null, "end1", null, 1, 1, ACDMAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNIQUE, IS_ORDERED);
        initEReference(getACDMAssociation_End2(), this.getACDMClass(), null, "end2", null, 1, 1, ACDMAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNIQUE, IS_ORDERED);

        createResource(eNS_URI);
    }

    @Override
    public EClass getACDMClass() { return acdmClassEClass; }
    @Override
    public EAttribute getACDMClass_Name() { return (EAttribute)acdmClassEClass.getEStructuralFeatures().get(ACDMCLASS__NAME); }
    @Override
    public EReference getACDMClass_Attributes() { return (EReference)acdmClassEClass.getEStructuralFeatures().get(ACDMCLASS__ATTRIBUTES); }

    @Override
    public EClass getACDMAttribute() { return acdmAttributeEClass; }
    @Override
    public EAttribute getACDMAttribute_Name() { return (EAttribute)acdmAttributeEClass.getEStructuralFeatures().get(ACDMATTRIBUTE__NAME); }
    @Override
    public EAttribute getACDMAttribute_Type() { return (EAttribute)acdmAttributeEClass.getEStructuralFeatures().get(ACDMATTRIBUTE__TYPE); }

    @Override
    public EClass getACDMAssociation() { return acdmAssociationEClass; }
    @Override
    public EReference getACDMAssociation_End1() { return (EReference)acdmAssociationEClass.getEStructuralFeatures().get(ACDMASSOCIATION__END1); }
    @Override
    public EReference getACDMAssociation_End2() { return (EReference)acdmAssociationEClass.getEStructuralFeatures().get(ACDMASSOCIATION__END2); }

    @Override
    public ACDMFactory getACDMFactory() { return (ACDMFactory)getEFactoryInstance(); }
}
