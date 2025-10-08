import {useState} from "react";


function Fruit(){

	let fruits = ["Mango", "Apple", "Lichi"];

	return (
		<>
			<ul>
				{fruits.map((fruit,index)=>(
					<li key={index}>{fruit}</li>
				))}
			</ul>
		</>
	);
}

export default Fruit;	
