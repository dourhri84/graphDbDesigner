// eCommerce Graph Model (Query-Driven GLDM)
// Neo4j Schema Definition

// -------- Node Label Constraints (UNIQUENESS) --------

CREATE CONSTRAINT client_login_unique IF NOT EXISTS
FOR (c:Client) REQUIRE c.login IS UNIQUE;

CREATE CONSTRAINT addr_id_unique IF NOT EXISTS
FOR (a:Address) REQUIRE a.addr_id IS UNIQUE;

CREATE CONSTRAINT order_oid_unique IF NOT EXISTS
FOR (o:Order) REQUIRE o.oid IS UNIQUE;

CREATE CONSTRAINT payment_number_unique IF NOT EXISTS
FOR (p:Payment) REQUIRE p.pm_number IS UNIQUE;

CREATE CONSTRAINT remoteaccess_id_unique IF NOT EXISTS
FOR (r:RemoteAccess) REQUIRE r.idAccess IS UNIQUE;

CREATE CONSTRAINT creditcard_number_unique IF NOT EXISTS
FOR (cc:CreditCard) REQUIRE cc.card_number IS UNIQUE;

CREATE CONSTRAINT debitcard_number_unique IF NOT EXISTS
FOR (dc:DebitCard) REQUIRE dc.card_number IS UNIQUE;

CREATE CONSTRAINT product_ref_unique IF NOT EXISTS
FOR (p:Product) REQUIRE p.reference IS UNIQUE;

CREATE CONSTRAINT category_code_unique IF NOT EXISTS
FOR (ctg:Category) REQUIRE ctg.code IS UNIQUE;

CREATE CONSTRAINT seller_id_unique IF NOT EXISTS
FOR (s:Seller) REQUIRE s.seller_gov_id IS UNIQUE;

// -------- Indexes for Optimization (from workload Q1–Q5) --------

CREATE INDEX idx_Q1_ClientLogin IF NOT EXISTS
FOR (c:Client) ON (c.login);

CREATE INDEX idx_Q2_SellerGov IF NOT EXISTS
FOR (s:Seller) ON (s.seller_gov_id);

CREATE INDEX idx_Q2_Warranty IF NOT EXISTS
FOR (rel:PROVIDES) ON (rel.warranty);

CREATE INDEX idx_Q3_ClientType IF NOT EXISTS
FOR (c:Client) ON (c.type);

CREATE INDEX idx_Q4_ClientLogin IF NOT EXISTS
FOR (c:Client) ON (c.login);

CREATE INDEX idx_Q4_Sequence IF NOT EXISTS
FOR (o:Order) ON (o.sequenceNumber);

CREATE INDEX idx_Q5_ClientLogin IF NOT EXISTS
FOR (c:Client) ON (c.login);

// -------- Relationship Types (implicit by usage) --------

// Client MAKES Order
// Client PAYS Order
// Client participates in Order
// RemoteAccess USES Payment
// Payment CONCERNS1 DebitCard
// Payment CONCERNS2 CreditCard
// Order CONTAINS Product, Seller (via CONTAINS node)
// Seller PROVIDES Product (with inStockQty, warranty)
// Client REFERRAL (reflexive, roles: referrer, referred)
// Client HAS Address
// Category IS_COMPOSED_OF Product
// Order IS_COMPOSED_OF2 Payment
// Warranty linked to Seller and Product
// typeOfClient relation (Client → Type)
// Order NEXT Order (sequence link)
// CategoriesPurchasedByClient (Client → Category)
