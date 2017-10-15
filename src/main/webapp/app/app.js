'use strict';

define(['angular', 'i18n!i18n-nls/diary/nls/diary-i18n', 'controllers/controllers', 'filters/filters', 'services/services', 'directives/directives',
	'angular.resource', 'angular.InfiniteScroll'], function (angular, i18n) {

	const dependencies = ['ngRoute', 'ngResource', 'ui.bootstrap', 'infinite-scroll', 'app.controllers', 'app.filters', 'app.services', 'app.directives'];

	const app = angular.module('app', dependencies);

	app.run(($rootScope, $location) => {
		$rootScope.breadCrumb = {};
		$rootScope.settings = {};

	});

	return app;
});
