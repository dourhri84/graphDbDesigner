package org.graphdesign.acdm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.graphdesign.acdm.*;

/**
 * The Adapter Factory for the ACDM model.
 */
public class ACDMAdapterFactory extends AdapterFactoryImpl {
    protected static ACDMPackage modelPackage;

    public ACDMAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ACDMPackage.eINSTANCE;
        }
    }

    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    protected ACDMSwitch<Adapter> modelSwitch =
        new ACDMSwitch<Adapter>() {
            @Override
            public Adapter caseACDMClass(ACDMClass object) {
                return createACDMClassAdapter();
            }
            @Override
            public Adapter caseACDMAttribute(ACDMAttribute object) {
                return createACDMAttributeAdapter();
            }
            @Override
            public Adapter caseACDMAssociation(ACDMAssociation object) {
                return createACDMAssociationAdapter();
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

    public Adapter createACDMClassAdapter() { return null; }
    public Adapter createACDMAttributeAdapter() { return null; }
    public Adapter createACDMAssociationAdapter() { return null; }
    public Adapter createEObjectAdapter() { return null; }
}
