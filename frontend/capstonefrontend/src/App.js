import logo from './logo.svg';
import './App.css';
import { Route, Switch } from 'react-router-dom';
import home from './././Components/home';
import searchingredient from './Components/searchingredient';
import Search from './././Components/search';
import findrecipes from './Components/findrecipes';
import signup from './Components/signup';



function App() {
  return (
    <div className="App">
    
      <Switch>
      <Route path = '/'  component={home} exact/>
      <Route path ='/searchingredient' component={searchingredient} exact/>
      <Route path ='/findrecipes' component={findrecipes} exact/>
      <Route path ='/signup' component={signup} exact/>
      </Switch>
      {/* <Search /> */}
    </div>
    
  );
}


export default App;
