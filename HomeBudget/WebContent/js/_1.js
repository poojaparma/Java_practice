var app = angular.module('myApp', ['ngGrid']);
app.controller('MyCtrl', function($scope) {
    $scope.myData = [{Dailyexpenditure: 'Kyle Hayhurst', MedicalExpenses: 25, KidExpenses: 'Javascript', TravellingExpenses: 1,vehicleExpenses:2,Billpayments:1000,Rent:122,cosmetics:11,OfficeExpenses:2333, id: 3},
		{Dailyexpenditure: 'Kyle Hayhurst', MedicalExpenses: 25, KidExpenses: 'Javascript', TravellingExpenses: 1,vehicleExpenses:2,Billpayments:1000,Rent:122,cosmetics:11,OfficeExpenses:2333, id: 3},
			{Dailyexpenditure: 'Kyle Hayhurst', MedicalExpenses: 25, KidExpenses: 'Javascript', TravellingExpenses: 1,vehicleExpenses:2,Billpayments:1000,Rent:122,cosmetics:11,OfficeExpenses:2333, id: 3},
				{Dailyexpenditure: 'Kyle Hayhurst', MedicalExpenses: 25, KidExpenses: 'Javascript', TravellingExpenses: 1,vehicleExpenses:2,Billpayments:1000,Rent:122,cosmetics:11,OfficeExpenses:2333, id: 3},
					{Dailyexpenditure: 'Kyle Hayhurst', MedicalExpenses: 25, KidExpenses: 'Javascript', TravellingExpenses: 1,vehicleExpenses:2,Billpayments:1000,Rent:122,cosmetics:11,OfficeExpenses:2333, id: 3}];
    $scope.gridOptions = { 
        data: 'myData',
        showGroupPanel: true,
        columnDefs: [{field: 'Dailyexpenditure', displayName: 'Daliy Expenditure'},
            {field: 'MedicalExpenses', displayName: 'Medical Expenses'},
            {field: 'KidExpenses', displayName: 'Kid Expenses'},
			 {field: 'TravellingExpenses', displayName: 'Travellig Expenses'},
			  {field: 'vehicleExpenses', displayName: 'vehicle Expenses'},
			    {field: 'Billpayments', displayName: 'Bill payments'},
				{field: 'Rent', displayName: 'Rent'},
				{field: 'cosmetics', displayName: 'cosmetics'},
				{field: 'OfficeExpenses', displayName: 'Office Expenses'},
            {displayName: 'Options', cellTemplate: '<input type="button" name="view" onclick="alert(\'You clicked view on item ID: {{row.entity.id}} \')" value="View">&nbsp;<input type="button" name="edit" onclick="alert(\'You clicked edit on item ID: {{row.entity.id}} \')" value="Edit">&nbsp;<input type="button" onclick="alert(\'You clicked delete on item ID: {{row.entity.id}} \')" name="delete" value="Delete">'}
            ]
    };
});