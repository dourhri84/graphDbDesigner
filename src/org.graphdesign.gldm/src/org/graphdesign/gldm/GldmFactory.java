package org.graphdesign.gldm;

import org.eclipse.emf.ecore.EFactory;

/**
 * The Factory for the GLDM model.
 * It provides a create method for each non-abstract class of the model.
 */
public interface GLDMFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     */
    GLDMFactory eINSTANCE = org.graphdesign.gldm.impl.GLDMFactoryImpl.init();

    /**
     * Returns a new object of class 'NodeLabel'.
     */
    NodeLabel createNodeLabel();

    /**
     * Returns a new object of class 'Property'.
     */
    Property createProperty();

    /**
     * Returns a new object of class 'RelationshipType'.
     */
    RelationshipType createRelationshipType();

    /**
     * Returns the package supported by this factory.
     */
    GLDMPackage getGLDMPackage();
}
