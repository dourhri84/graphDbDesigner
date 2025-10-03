/**
 * <copyright>
 *   Package interface for the CDM (Class Diagram Metamodel).
 *   Defines constants for meta-objects such as classes, features, and operations.
 * </copyright>
 */
package org.graphdesign.cdm;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EAttribute;

/**
 * The Package for the CDM model.
 * It contains accessors for the meta objects to represent:
 *   - each class,
 *   - each feature of each class,
 *   - each enum,
 *   - and each data type.
 */
public interface CDMPackage extends EPackage {
    /**
     * The package name.
     */
    String eNAME = "cdm";

    /**
     * The package namespace URI.
     */
    String eNS_URI = "http://www.graphdesign.org/cdm/1.0";

    /**
     * The package namespace name.
     */
    String eNS_PREFIX = "cdm";

    /**
     * The singleton instance of the package.
     */
    CDMPackage eINSTANCE = org.graphdesign.cdm.impl.CDMPackageImpl.init();

    // -------------------------
    // Meta object IDs
    // -------------------------

    int CDMCLASS = 0;
    int ATTRIBUTE = 1;

    // -------------------------
    // Features of CDMClass
    // -------------------------

    int CDMCLASS__NAME = 0;
    int CDMCLASS__ATTRIBUTES = 1;

    // -------------------------
    // Features of Attribute
    // -------------------------

    int ATTRIBUTE__NAME = 0;
    int ATTRIBUTE__TYPE = 1;

    // -------------------------
    // Accessors for meta objects
    // -------------------------

    /**
     * Returns the meta object for class 'CDMClass'.
     */
    EClass getCDMClass();

    /**
     * Returns the meta object for the attribute 'CDMClass.name'.
     */
    EAttribute getCDMClass_Name();

    /**
     * Returns the meta object for the containment reference list 'CDMClass.attributes'.
     */
    EReference getCDMClass_Attributes();

    /**
     * Returns the meta object for class 'Attribute'.
     */
    EClass getAttribute();

    /**
     * Returns the meta object for the attribute 'Attribute.name'.
     */
    EAttribute getAttribute_Name();

    /**
     * Returns the meta object for the attribute 'Attribute.type'.
     */
    EAttribute getAttribute_Type();

    /**
     * Returns the factory that creates the instances of the model.
     */
    CDMFactory getCDMFactory();

    // -------------------------
    // Literals for easy access
    // -------------------------

    interface Literals {
        /**
         * The meta object literal for the 'CDMClass' class.
         */
        EClass CDMCLASS = eINSTANCE.getCDMClass();

        /**
         * The meta object literal for the feature 'CDMClass.name'.
         */
        EAttribute CDMCLASS__NAME = eINSTANCE.getCDMClass_Name();

        /**
         * The meta object literal for the feature 'CDMClass.attributes'.
         */
        EReference CDMCLASS__ATTRIBUTES = eINSTANCE.getCDMClass_Attributes();

        /**
         * The meta object literal for the 'Attribute' class.
         */
        EClass ATTRIBUTE = eINSTANCE.getAttribute();

        /**
         * The meta object literal for the feature 'Attribute.name'.
         */
        EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

        /**
         * The meta object literal for the feature 'Attribute.type'.
         */
        EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();
    }
}
