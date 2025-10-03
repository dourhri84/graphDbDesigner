/**
 * <copyright>
 *   Factory interface for the CDM (Class Diagram Metamodel).
 *   Provides methods for creating instances of the model.
 * </copyright>
 */
package org.graphdesign.cdm;

import org.eclipse.emf.ecore.EFactory;

/**
 * The Factory for the CDM model.
 * It provides a create method for each non-abstract class of the model.
 */
public interface CDMFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     */
    CDMFactory eINSTANCE = org.graphdesign.cdm.impl.CDMFactoryImpl.init();

    /**
     * Returns a new object of class 'Class'.
     */
    CDMClass createCDMClass();

    /**
     * Returns a new object of class 'Attribute'.
     */
    Attribute createAttribute();

    /**
     * Returns the package supported by this factory.
     */
    CDMPackage getCDMPackage();
}
