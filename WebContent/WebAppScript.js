var EasyCMApp = angular.module("EasyCMApp", [ 'ui.bootstrap' ]);
EasyCMApp.factory('EasyCMScriptService', [
		'$http',
		'$filter',
		function($http, $filter) {
			return {

				addMA : function(newUserCreds) {
					return $http.post(
							"/HibernateWebApp/easyCM?c=addMa&name=" + newUserCreds.Name
									+ "&vorname=" + newUserCreds.Vorname
									+ "&adresse=" + newUserCreds.Adresse
									+ "&telnr=" + newUserCreds.TelNr)
							.success(function(data) {
								return data;
							})
				}

			};
		} ]);
// ///////////////////////////// controller
EasyCMApp.controller('EasyCMScriptCtrl', [ '$http', '$scope',
		'EasyCMScriptService', function($http, $scope, EasyCMScriptService) {

			$scope.newUserCreds = {
				Name : 'Name',
				Vorname : 'Vorname',
				Adresse : 'Adresse',
				TelNr : 'Telefonnummer'
			};
			$scope.searchEntry 
			$scope.openMaRegister = function(){
				
			}

			
			$scope.testfunction = function() {
				var a = 1;
				a++;
				$scope.newUserCreds.NeuName = $scope.newUserCreds.Name
			};

			$scope.addMA = function() {
				EasyCMScriptService.addMA($scope.newUserCreds).success(
						function(data) {
							//Reset newUserCreds
							$scope.newUserCreds.Name = 'Name';
							$scope.newUserCreds.Vorname = 'Vorname';
							$scope.newUserCreds.Adresse = 'Adresse';
							$scope.newUserCreds.TelNr = 'Telefonnummer';
								
						})
			};

		} ]);
