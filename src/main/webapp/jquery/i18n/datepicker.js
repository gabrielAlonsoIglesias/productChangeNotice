//devuelve los dias de la semana en funcion del idioma
function getDaysOfWeek(locale) {
	if (locale == 'es') {
		return ['D', 'L', 'M', 'X', 'J', 'V', 'S'];
	}	
	if (locale == 'en') {
		return ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'];	
	}
	if (locale == 'pt') {
		return ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'];
	}
}

//devuelve los meses del año en funcion del idioma
function getMonthsOfYear(locale) {
	if (locale == 'es') {
		return ['Enero','Febrero','Marzo','Abril','Mayo','Junio', 'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
	}
	if (locale == 'en') {
		return ['January','February','March','April','May','June', 'July','August','September','October','November','December'];
	}
	if (locale == 'pt') {
		return ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
	}
}

function getButtons(locale) {
	if (locale == 'es') {
		return ['OK', 'Ant', 'Sig', 'Hoy'];
	}
	if (locale == 'en') {
		return ['OK', 'Prev', 'Next', 'Today'];
	}
	if (locale == 'pt') {
		return ['OK', 'Ant', 'Seg', 'Hoje'];
	}
	
}

