'use strict';

require.config({

	paths: {
		'i18n': '/js/lib/i18n-2.0.4',
		'underscore': '/js/lib/underscore-1.8.3',
		'jquery': '/js/lib/jquery-2.1.1',
		'jquery.ui': '/js/lib/jquery-ui-1.10.4.min',
		'jquery.easing': 'vendor/jquery-easing/jquery.easing.min',
		'bootstrap': '/js/lib/bootstrap.min',
		'toastr': '/js/plugins/toastr/toastr.min',
		'sweetalert': '/js/plugins/sweetalert/sweetalert.min',
		'moment': '/js/lib/moment.min',
		'sb-admin': '/js/sb-admin',
		'popper': '/vendor/popper/popper',
		'chart': '/vendor/chart.js/Chart.min',
		'angular': '/js/lib/angular.min', //AngularJS v1.5.7
		'angular.route': '/js/lib/angular-route',
		'angular.resource': '/js/lib/angular-resource',
		'angular.ui.bootstrap': '/js/lib/angular-ui-bootstrap',
		'angular.InfiniteScroll': '/js/lib/ng-infinite-scroll.min',
	},
	shim: {
		'jquery.ui': {
			deps: ['jquery']
		},
		'bootstrap': {
			deps: ['jquery', 'jquery.ui', 'popper']
		},
		'toast': {
			deps: ['jquery', 'jquery.ui', 'bootstrap']
		},
		'sweetalert': {
			deps: ['jquery', 'jquery.ui', 'bootstrap']
		},
		'popper': {
			deps: ['jquery'],
		},
		'jquery.easing': {
			deps: ['jquery', 'jquery-ui'],
		},
		'angular': {
			deps: ['jquery'],
			exports: 'angular'
		},
		'angular.route': {
			deps: ['angular'],
		},
		'angular.resource': {
			deps: ['angular', 'angular.route']
		},
		'angular.ui.bootstrap': {
			deps: ['angular']
		},
		'angular.InfiniteScroll': { //https://sroze.github.io/ngInfiniteScroll/demo_basic.html#
			deps: ['angular']
		},
		'app': {
			deps: ['angular']
		},
	},
});

const importDependencies = ['jquery', 'angular', 'underscore', 'app', 'toastr', 'sweetalert', 'jquery.ui', 'bootstrap',
	'angular.route', 'angular.resource', 'angular.ui.bootstrap', 'angular.InfiniteScroll', 'moment','popper'];

require(importDependencies, ($, angular, _, app, toastr) => {

	$(() => {
		/**
		 * @type {angular.Module}
		 */
		angular.bootstrap(document, ['app']);    //  app start
	});

});
