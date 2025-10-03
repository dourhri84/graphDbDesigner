package org.graphdesign.dqrm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.graphdesign.dqrm.*;

/**
 * The Adapter Factory for the DQRM model.
 */
public class DQRMAdapterFactory extends AdapterFactoryImpl {
    protected static DQRMPackage modelPackage;

    public DQRMAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = DQRMPackage.eINSTANCE;
        }
    }

    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) return true;
        if (object instanceof EObject) return ((EObject)object).eClass().getEPackage() == modelPackage;
        return false;
    }

    protected DQRMSwitch<Adapter> modelSwitch =
        new DQRMSwitch<Adapter>() {
            @Override
            public Adapter caseDQRMModel(DQRMModel object) {
                return createDQRMModelAdapter();
            }
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
            public Adapter caseFunctionalReq(FunctionalReq object) {
                return createFunctionalReqAdapter();
            }
            @Override
            public Adapter caseQueryDecl(QueryDecl object) {
                return createQueryDeclAdapter();
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

    public Adapter createDQRMModelAdapter() { return null; }
    public Adapter createNodeLabelAdapter() { return null; }
    public Adapter createPropertyAdapter() { return null; }
    public Adapter createRelationshipTypeAdapter() { return null; }
    public Adapter createFunctionalReqAdapter() { return null; }
    public Adapter createQueryDeclAdapter() { return null; }
    public Adapter createEObjectAdapter() { return null; }
}
