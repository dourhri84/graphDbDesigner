GraphDesign



Copyright (C) 2025 Ahmed Dourhri



GraphDesign is a tool that allows the design and generation of graph-oriented database schemas (Neo4j) from a conceptual specification.



The generic specification is defined through an instance of a Class Diagram Metamodel (CDM).

This repository contains all metamodels of GraphDesign’s translation process, as well as the transformations and code generation templates that are used to transform a conceptual CDM instance into final optimized implementation schemas in Neo4j.



GraphDesign follows a Model-Driven Architecture (MDA) approach, covering CIM → PIM → PSM transformations.



This tool is in an early stage of development, so expect possible bugs and structural changes in its contents.



Structure of the org.graphdesign.\* projects



org.graphdesign.cdm

Metamodel for Class Diagrams (conceptual level). Defines classes, attributes, and associations.



org.graphdesign.acdm

Adjusted Class Diagram Metamodel. Removes inheritance, compositions, aggregations, and n-ary associations to prepare the model for graph representation.



org.graphdesign.gldm

Graph Logical Data Metamodel (GLDM). Provides the logical representation of graph databases using NodeLabels and RelationshipTypes.



org.graphdesign.dqrm

Data \& Query Related Metamodel (DQRM). Couples a GLDM with a set of functional access queries (Cypher-like). This allows schema optimization based on queries.



org.graphdesign.qdgldm

Query-Driven GLDM. Produces an optimized schema enriched with generic relationships, fact nodes, type-of-client nodes, sequence links, implicit relationships, and indexing strategies derived from query access patterns.



org.graphdesign.\*.xtext

Xtext-based DSLs for textual specification of CDM, ACDM, GLDM, DQRM, and QDGLDM instances.



org.graphdesign.transformations

ATL (model-to-model) transformations:



CDM2ACDM.atl



ACDM2GLDM.atl



GLDM2DQRM.atl



GLDM2QDGLDM.atl



org.graphdesign.generators

Model-to-Text (M2T) generators (Xtend/EGL) for producing Cypher code:



Schema creation (\*\_schema.cypher)




examples/

Includes a running example (eCommerce) with different model instances (eCommerce.cdm, eCommerce.acdm, eCommerce.gldm, eCommerce.dqrm, eCommerce.qdgldm) and generated Neo4j scripts (eCommerce\_schema.cypher).



Required Eclipse Packages



Eclipse Modeling Tools



EMF (Ecore/Xcore)



Xtext



ATL / Epsilon (for transformations)



(Optional) Sirius for visual modeling



(Optional) PlantUML for Ecore visualization



Installation and Usage



Import all projects except the examples project into Eclipse.



For each metamodel project (cdm, acdm, gldm, dqrm, qdgldm):



Open model/<name>.genmodel



Right-click → Generate Model Code.



For each Xtext project:



Open the .xtext grammar in src/



Launch Generate Xtext Artifacts.



Run the Xtext editor using the provided LaunchRuntime… configuration.



Import the examples project into the runtime workspace.



Inspect eCommerce.\* instances to see a full end-to-end example.



Run ATL transformations (in org.graphdesign.transformations) to move from CDM to QDGLDM.



Use generators (in org.graphdesign.generators) to produce Cypher schema scripts.



Execute the generated Cypher files in Neo4j.



Example Workflow



Define a conceptual model → eCommerce.cdm



Transform into adjusted model → eCommerce.acdm (CDM2ACDM)



Transform into logical graph model → eCommerce.gldm (ACDM2GLDM)



Add query requirements → eCommerce.dqrm



Optimize schema with rules \& indexes → eCommerce.qdgldm (GLDM2QDGLDM)



Generate schema script → eCommerce\_schema.cypher





Load into Neo4j.



License



GraphDesign is distributed under free license

