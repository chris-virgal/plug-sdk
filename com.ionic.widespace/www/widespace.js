var cordova = require('cordova');

function Widespace() {
	var self = this;

	self.initSplashAd = function() {
		cordova.exec(function(){}, function(){}, "CDVWidespace", "initSplashAd", []);
	};

}

module.exports = new Widespace();