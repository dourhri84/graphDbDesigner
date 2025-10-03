package org.graphdesign.acdm;

import org.eclipse.emf.ecore.EFactory;

/**
 * The Factory for the ACDM model.
 * It provides a create method for each non-abstract class of the model.
 */
public interface ACDMFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     */
    ACDMFactory eINSTANCE = org.graphdesign.acdm.impl.ACDMFactoryImpl.init();

    /**
     * Returns a new object of class 'ACDMClass'.
     */
    ACDMClass createACDMClass();

    /**
     * Returns a new object of class 'ACDMAttribute'.
     */
    ACDMAttribute createACDMAttribute();

    /**
     * Returns a new object of class 'ACDMAssociation'.
     */
    ACDMAssociation createACDMAssociation();

    /**
     * Returns the package supported by this factory.
     */
    ACDMPackage getACDMPackage();
}
