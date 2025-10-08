const express = require(`express`);
const path = require(`path`);
const app = express();

app.get(`/status`,(req,res)=>{
	res.status(200).send(`Success`);
	});

app.get(`/redirect`,(req,res)=>{
	res.redirect(`http://www.google.com`);
	});

app.get(`/file`,(req,res)=>{
	const patho = path.resolve(`Test`,`txt.html`);
	const option = {
			headers : {
				"Content-Type" : "text/html"
				}
			};

	res.sendFile(patho ,option ,(err)=>{
		if(err){
			res.status(404).send(`Something went wrong`);
		}else{
			console.log(`File sent successfuly`);
		}
	});
});

app.get(`/sethed`, (req,res)=>{
	res.set("Content-Type","text/plain");
	res.send(`Hello content`);
});

app.get("/download", (req, res) => {
    res.set({
        "Content-Disposition": "attachment; filename=example.txt",
        "Content-Type": "text/plain"
    });
    res.send("This is the content of the file.");
});


app.listen(3000);

