import "./Style.css";

export function Style(){
  return (<div className="body">
    <div className="containner"> 
    <div className="row">
      <div className="col-6 col">Half</div>
      <div className="col-6 col">Half</div>
    </div>
    
    <div className="row">
      <div className="col-4 col">1/3</div>
      <div className="col-8 col">2/3</div>
    </div>
    </div>
    <button className="btn btn-outline-danger" > ojgoirj</button>
    
    
    <h1>Coloms</h1>
    <h2>Alignment</h2>
    {/*Alignment on main axis*/}
    
    <div className="container">
      
      <h3>align-items-start</h3>
      <div className="row align-items-start" style={{ backgroundColor: "yellow", height: "100px"}}>
        <div className="col">Col 1</div>
        <div className="col">Col 2</div>
        <div className="col">Col 3</div>
        <div className="col">Col 4</div>
      </div>
      
      <h3>align-items-center</h3>
      <div className="row align-items-center" style={{ backgroundColor: "yellow", height: "100px"}}>
        <div className="col">Col 1</div>
        <div className="col">Col 2</div>
        <div className="col">Col 3</div>
        <div className="col">Col 4</div>
      </div>
      
      <h3>align-items-end</h3>
      <div className="row align-items-end" style={{ backgroundColor: "yellow", height: "100px"}}>
        <div className="col">Col 1</div>
        <div className="col">Col 2</div>
        <div className="col">Col 3</div>
        <div className="col">Col 4</div>
      </div>
    </div>
    
    
    
    <h2>Self Alignment</h2>
    {/*Alignment on main axis*/}
    
    <div className="container">
      
      <h3>align-self-start</h3>
      <div className="row" style={{ backgroundColor: "yellow", height: "100px"}}>
        <div className="col align-self-start">Col 1</div>
        <div className="col align-self-center">Col 2</div>
        <div className="col align-self-end">Col 3</div>
      </div>
    </div>
    
    <h1 className="h1" style={{ backgroundColor: "green"}}>H1</h1>
    <h2 className="h2" style={{ backgroundColor: "green"}}>H2</h2>
    <h3 className="h3" style={{ backgroundColor: "green"}}>H3</h3>
    
    
    <div className="display-1" style={{ backgroundColor: "pink"}}>Display-1</div>
    <div className="display-4" style={{ backgroundColor:
    "pink"}}>Display-4</div>
    
    <p className="lead" style={{ backgroundColor: "red"}}>Lead</p>
    <p className="small" style={{ backgroundColor: "red"}}>Small</p>
    
    <div className="text-start" style={{ backgroundColor:
    "aqua"}}>Text-Start</div>
    <div className="text-center" style={{ backgroundColor:
    "aqua"}}>Text-Center</div>
    <div className="text-end" style={{ backgroundColor: "aqua"}}>Text-End</div>
    
    
    <div className="text-primary">Text-Primary</div>
    <div className="text-success">Text-Success</div>
    <div className="text-danger">Text-Denger</div>
    
    <div className="bg-danger">BG-ganger</div>
    <div className="bg-success">BG-success</div>
    <div className="bg-light">BG-success</div>
    
    
    
    
    
    
    
    
    
    
  </div>)
}