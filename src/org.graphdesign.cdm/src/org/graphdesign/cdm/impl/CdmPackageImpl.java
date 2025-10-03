/**
 * <copyright>
 *   Implementation of the Package for the CDM (Class Diagram Metamodel).
 *   It creates, registers, and initializes the meta-model objects (EClasses, features, etc.).
 * </copyright>
 */
package org.graphdesign.cdm.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.graphdesign.cdm.*;

/**
 * An implementation of the CDM Package.
 */
public class CDMPackageImpl extends EPackageImpl implements CDMPackage {
    /**
     * The singleton instance of the package.
     */
    private static boolean isInited = false;

    /**
     * The meta object for class 'CDMClass'.
     */
    private EClass cdmClassEClass = null;

    /**
     * The meta object for class 'Attribute'.
     */
    private EClass attributeEClass = null;

    /**
     * Creates an instance of the model package.
     */
    private CDMPackageImpl() {
        super(eNS_URI, CDMFactory.eINSTANCE);
    }

    /**
     * Initializes the package, ensuring it is registered.
     */
    public static CDMPackage init() {
        if (isInited) return (CDMPackage)EPackage.Registry.INSTANCE.getEPackage(CDMPackage.eNS_URI);

        // Create and register the package
        CDMPackageImpl theCDMPackage = new CDMPackageImpl();
        isInited = true;

        // Create package meta-data objects
        theCDMPackage.createPackageContents();

        // Initialize created meta-data
        theCDMPackage.initializePackageContents();

        // Register the package
        EPackage.Registry.INSTANCE.put(CDMPackage.eNS_URI, theCDMPackage);
        return theCDMPackage;
    }

    /**
     * Creates the meta-model objects for the package.
     */
    private boolean isCreated = false;

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        cdmClassEClass = createEClass(CDMCLASS);
        createEAttribute(cdmClassEClass, CDMCLASS__NAME);
        createEReference(cdmClassEClass, CDMCLASS__ATTRIBUTES);

        attributeEClass = createEClass(ATTRIBUTE);
        createEAttribute(attributeEClass, ATTRIBUTE__NAME);
        createEAttribute(attributeEClass, ATTRIBUTE__TYPE);
    }

    /**
     * Initializes the meta-model objects.
     */
    private boolean isInitialized = false;

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Initialize classes and features
        initEClass(cdmClassEClass, CDMClass.class, "CDMClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCDMClass_Name(), ecorePackage.getEString(), "name", null, 1, 1, CDMClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCDMClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, CDMClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Type(), ecorePackage.getEString(), "type", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

    // -------------------------
    // Getters for EClasses
    // -------------------------

    @Override
    public EClass getCDMClass() {
        return cdmClassEClass;
    }

    @Override
    public EAttribute getCDMClass_Name() {
        return (EAttribute)cdmClassEClass.getEStructuralFeatures().get(CDMCLASS__NAME);
    }

    @Override
    public EReference getCDMClass_Attributes() {
        return (EReference)cdmClassEClass.getEStructuralFeatures().get(CDMCLASS__ATTRIBUTES);
    }

    @Override
    public EClass getAttribute() {
        return attributeEClass;
    }

    @Override
    public EAttribute getAttribute_Name() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(ATTRIBUTE__NAME);
    }

    @Override
    public EAttribute getAttribute_Type() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(ATTRIBUTE__TYPE);
    }

    @Override
    public CDMFactory getCDMFactory() {
        return (CDMFactory)getEFactoryInstance();
    }
}
