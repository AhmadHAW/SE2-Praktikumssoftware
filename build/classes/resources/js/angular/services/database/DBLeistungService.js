/**
 * Service
 **/
(function() {

  // Hauptapp referenzieren damit Service sichtbar wird
  var app = angular.module("SE2-Software");

  // Servicedefinition
  var DBLeistungService = function($http) {

	var url = "http://localhost:8080/SE2-Praktikumssoftware/";

    // Gebe dieses Object zurück und mache die Methoden zugänglich
    // -----------------------------------------------------------------
    return {

    };
    // ----------------------------------------------------------------
  };

  // Service bei der Hauptapp als "Service" über factory-Methode anmelden
  app.factory("DBLeistungService", DBLeistungService);

  // Code sofort ausführen
}());
