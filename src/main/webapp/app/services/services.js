'use strict';

define(function (require) {

	let angular = require('angular'),
		config = require('config'),
		services = angular.module('app.services', ['app.config']);

	//services.factory('UserService', require('services/api/user.service'));

	return services;
});
