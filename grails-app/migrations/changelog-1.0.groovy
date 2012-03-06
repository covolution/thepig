databaseChangeLog = {

	changeSet(author: "gjames (generated)", id: "1331069228636-1") {
		createTable(tableName: "feast") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "feastPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "due_at", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "host_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-2") {
		createTable(tableName: "ingredient") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "ingredientPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "ingredient_group", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-3") {
		createTable(tableName: "meal") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mealPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "feast_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "person_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-4") {
		createTable(tableName: "person") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "personPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "forename", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "surname", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-5") {
		createTable(tableName: "person_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "person_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-6") {
		createTable(tableName: "portion") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "portionPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "ingredient_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "meal_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "quantity", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-7") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-8") {
		addPrimaryKey(columnNames: "role_id, person_id", constraintName: "person_rolePK", tableName: "person_role")
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-9") {
		createIndex(indexName: "FK5CCC16396EB286B", tableName: "feast") {
			column(name: "host_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-10") {
		createIndex(indexName: "unique-name", tableName: "ingredient") {
			column(name: "ingredient_group")

			column(name: "name")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-11") {
		createIndex(indexName: "FK3313C35D75CD09", tableName: "meal") {
			column(name: "feast_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-12") {
		createIndex(indexName: "FK3313C38849079E", tableName: "meal") {
			column(name: "person_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-13") {
		createIndex(indexName: "unique-person_id", tableName: "meal") {
			column(name: "feast_id")

			column(name: "person_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-14") {
		createIndex(indexName: "email_unique_1331069228500", tableName: "person", unique: "true") {
			column(name: "email")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-15") {
		createIndex(indexName: "username_unique_1331069228503", tableName: "person", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-16") {
		createIndex(indexName: "FKE6A16B208849079E", tableName: "person_role") {
			column(name: "person_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-17") {
		createIndex(indexName: "FKE6A16B20FCA698FE", tableName: "person_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-18") {
		createIndex(indexName: "FKE8A0A3E743C2BACB", tableName: "portion") {
			column(name: "meal_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-19") {
		createIndex(indexName: "FKE8A0A3E7D773DF4B", tableName: "portion") {
			column(name: "ingredient_id")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-20") {
		createIndex(indexName: "authority_unique_1331069228514", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-21") {
		addForeignKeyConstraint(baseColumnNames: "host_id", baseTableName: "feast", constraintName: "FK5CCC16396EB286B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", referencesUniqueColumn: "false")
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-22") {
		addForeignKeyConstraint(baseColumnNames: "feast_id", baseTableName: "meal", constraintName: "FK3313C35D75CD09", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "feast", referencesUniqueColumn: "false")
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-23") {
		addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "meal", constraintName: "FK3313C38849079E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", referencesUniqueColumn: "false")
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-24") {
		addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "person_role", constraintName: "FKE6A16B208849079E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", referencesUniqueColumn: "false")
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-25") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "person_role", constraintName: "FKE6A16B20FCA698FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-26") {
		addForeignKeyConstraint(baseColumnNames: "ingredient_id", baseTableName: "portion", constraintName: "FKE8A0A3E7D773DF4B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "ingredient", referencesUniqueColumn: "false")
	}

	changeSet(author: "gjames (generated)", id: "1331069228636-27") {
		addForeignKeyConstraint(baseColumnNames: "meal_id", baseTableName: "portion", constraintName: "FKE8A0A3E743C2BACB", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "meal", referencesUniqueColumn: "false")
	}
}
