package org.graphdesign.gldm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.graphdesign.gldm.*;

/**
 * The Adapter Factory for the GLDM model.
 */
public class GLDMAdapterFactory extends AdapterFactoryImpl {
    protected static GLDMPackage modelPackage;

    public GLDMAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = GLDMPackage.eINSTANCE;
        }
    }

    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) return true;
        if (object instanceof EObject) return ((EObject)object).eClass().getEPackage() == modelPackage;
        return false;
    }

    protected GLDMSwitch<Adapter> modelSwitch =
        new GLDMSwitch<Adapter>() {
            @Override
            public Adapter caseNodeLabel(NodeLabel object) {
                return createNodeLabelAdapter();
            }
            @Override
            public Adapter caseProperty(Property object) {
                return createPropertyAdapter();
            }
            @Override
            public Adapter caseRelationshipType(RelationshipType object) {
                return createRelationshipTypeAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }

    public Adapter createNodeLabelAdapter() { return null; }
    public Adapter createPropertyAdapter() { return null; }
    public Adapter createRelationshipTypeAdapter() { return null; }
    public Adapter createEObjectAdapter() { return null; }
}
