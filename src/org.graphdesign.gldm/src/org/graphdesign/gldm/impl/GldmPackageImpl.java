package org.graphdesign.gldm.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.graphdesign.gldm.*;

/**
 * Implementation of the GLDM Package.
 */
public class GLDMPackageImpl extends EPackageImpl implements GLDMPackage {
    private EClass nodeLabelEClass = null;
    private EClass propertyEClass = null;
    private EClass relationshipTypeEClass = null;

    private static boolean isInited = false;

    private GLDMPackageImpl() {
        super(eNS_URI, GLDMFactory.eINSTANCE);
    }

    public static GLDMPackage init() {
        if (isInited) return (GLDMPackage)EPackage.Registry.INSTANCE.getEPackage(GLDMPackage.eNS_URI);
        GLDMPackageImpl theGLDMPackage = new GLDMPackageImpl();
        isInited = true;

        theGLDMPackage.createPackageContents();
        theGLDMPackage.initializePackageContents();
        EPackage.Registry.INSTANCE.put(GLDMPackage.eNS_URI, theGLDMPackage);
        return theGLDMPackage;
    }

    private boolean isCreated = false;

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

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
    }

    private boolean isInitialized = false;

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(nodeLabelEClass, NodeLabel.class, "NodeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNodeLabel_Name(), ecorePackage.getEString(), "name", null, 1, 1, NodeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNodeLabel_Properties(), this.getProperty(), null, "properties", null, 0, -1, NodeLabel.class, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNIQUE, IS_ORDERED);

        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProperty_Type(), ecorePackage.getEString(), "type", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProperty_Unique(), ecorePackage.getEBoolean(), "unique", "false", 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(relationshipTypeEClass, RelationshipType.class, "RelationshipType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRelationshipType_Name(), ecorePackage.getEString(), "name", null, 1, 1, RelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRelationshipType_Source(), this.getNodeLabel(), null, "source", null, 1, 1, RelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNIQUE, IS_ORDERED);
        initEReference(getRelationshipType_Target(), this.getNodeLabel(), null, "target", null, 1, 1, RelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNIQUE, IS_ORDERED);
        initEReference(getRelationshipType_Properties(), this.getProperty(), null, "properties", null, 0, -1, RelationshipType.class, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNIQUE, IS_ORDERED);
        initEAttribute(getRelationshipType_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, RelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        createResource(eNS_URI);
    }

    @Override
    public EClass getNodeLabel() { return nodeLabelEClass; }
    @Override
    public EAttribute getNodeLabel_Name() { return (EAttribute)nodeLabelEClass.getEStructuralFeatures().get(NODELABEL__NAME); }
    @Override
    public EReference getNodeLabel_Properties() { return (EReference)nodeLabelEClass.getEStructuralFeatures().get(NODELABEL__PROPERTIES); }

    @Override
    public EClass getProperty() { return propertyEClass; }
    @Override
    public EAttribute getProperty_Name() { return (EAttribute)propertyEClass.getEStructuralFeatures().get(PROPERTY__NAME); }
    @Override
    public EAttribute getProperty_Type() { return (EAttribute)propertyEClass.getEStructuralFeatures().get(PROPERTY__TYPE); }
    @Override
    public EAttribute getProperty_Unique() { return (EAttribute)propertyEClass.getEStructuralFeatures().get(PROPERTY__UNIQUE); }

    @Override
    public EClass getRelationshipType() { return relationshipTypeEClass; }
    @Override
    public EAttribute getRelationshipType_Name() { return (EAttribute)relationshipTypeEClass.getEStructuralFeatures().get(RELATIONSHIPTYPE__NAME); }
    @Override
    public EReference getRelationshipType_Source() { return (EReference)relationshipTypeEClass.getEStructuralFeatures().get(RELATIONSHIPTYPE__SOURCE); }
    @Override
    public EReference getRelationshipType_Target() { return (EReference)relationshipTypeEClass.getEStructuralFeatures().get(RELATIONSHIPTYPE__TARGET); }
    @Override
    public EReference getRelationshipType_Properties() { return (EReference)relationshipTypeEClass.getEStructuralFeatures().get(RELATIONSHIPTYPE__PROPERTIES); }
    @Override
    public EAttribute getRelationshipType_Kind() { return (EAttribute)relationshipTypeEClass.getEStructuralFeatures().get(RELATIONSHIPTYPE__KIND); }

    @Override
    public GLDMFactory getGLDMFactory() { return (GLDMFactory)getEFactoryInstance(); }
}
