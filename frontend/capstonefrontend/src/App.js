import logo from './logo.svg';
import './App.css';
import { Route, Switch } from 'react-router-dom';
import home from './Pages/home';
import searchingredient from './Pages/searchingredient';
import Search from './Components/search';
import findrecipecontainer from './Containers/findrecipecontainer';
import signup from './Pages/signup';
import findrecipe from './Pages/findrecipes';


function App() {
  return (
    <div className="App">
      <Switch>
      <Route path = '/'  component={home} exact/>
      <Route path ='/searchingredient' component={searchingredient} exact/>
      <Route path ='/findrecipes' component={findrecipe} exact/>
      <Route path ='/signup' component={signup} exact/>
      </Switch>
      {/* <Search /> */}
    </div>
    
  );
}


export default App;
