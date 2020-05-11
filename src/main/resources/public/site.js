
function attachListValidation() {
	const inputs = document.querySelectorAll('input[list]');
	inputs.forEach(node => { 
		 node.addEventListener('change', onLBoxInputChange);
		 const helpNode =  document.getElementById(node.id+"_help");
		 if(helpNode){
			 helpNode.addEventListener('click', ()=>{onLBoxInputHelp(node)});			 
		 } 
    });	
}


function onLBoxInputChange() {
	const self = this;
	const options = Array.from(self.list.options);
	const vals = options.map(opt => opt.value.toLowerCase());
	const selfValue = self.value.toLowerCase();
	
	const checkMatch = entry => entry == selfValue;
	const matchResult = vals.some(checkMatch);
	const msg = matchResult ? "" : 'Not a valid entry';
	self.setCustomValidity(msg);	
}

function onLBoxInputHelp(node) {
	const options = Array.from(node.list.options);
	const vals = options.map(opt => opt.value);
	const msg = "Valid entries are\n\n" + vals.join('\n');	
	alert(msg);
}

function onNumericInputHelp(helpnode) {
	alert("Enter numeric value");
}

setTimeout(attachListValidation, 200);
