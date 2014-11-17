var cordova = require('cordova');

function Widespace() {
	var self = this;

	self.initSplashAd = function() {
		cordova.exec(function(){}, function(){}, "CDVWidespace", "init", []);
	};

}

module.exports = new Widespace();