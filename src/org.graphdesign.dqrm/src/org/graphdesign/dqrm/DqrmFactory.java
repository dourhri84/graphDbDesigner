package org.graphdesign.dqrm;

import org.eclipse.emf.ecore.EFactory;

/**
 * The Factory for the DQRM model.
 * Provides a create method for each non-abstract class of the model.
 */
public interface DQRMFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     */
    DQRMFactory eINSTANCE = org.graphdesign.dqrm.impl.DQRMFactoryImpl.init();

    // ---- Core model elements ----
    DQRMModel createDQRMModel();
    NodeLabel createNodeLabel();
    Property createProperty();
    RelationshipType createRelationshipType();

    // ---- Functional requirements & queries ----
    FunctionalReq createFunctionalReq();
    QueryDecl createQueryDecl();

    // Return the package
    DQRMPackage getDQRMPackage();
}
