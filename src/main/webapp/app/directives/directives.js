
define(function (require) {

	'use strict';

	let angular = require('angular'),
		services = require('services/services'),
		directives = angular.module('app.directives', ['app.services']);

	//directives.directive('datepick', require('directives/datepick.directive'));

	return directives;
});
