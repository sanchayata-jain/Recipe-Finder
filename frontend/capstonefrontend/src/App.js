import logo from './logo.svg';
import './App.css';
import { Route, Switch } from 'react-router-dom';
import home from './Pages/home';
import searchingredient from './Pages/searchingredient';
import Search from './Components/search';
import findrecipes from './Pages/findrecipes';
import signup from './Pages/signup';
import Recipes from './Pages/recipes';
import Profile from './Pages/profile';
import AboutUs from './Pages/aboutus';


function App() {
  return (
    <div className="App">
      <Switch>
      <Route path = '/'  component={home} exact/>
      <Route path ='/searchingredient' component={searchingredient} exact/>
      <Route path ='/findrecipes' component={findrecipes} exact/>
      <Route path ='/signup' component={signup} exact/>
      <Route path = '/recipes' component={Recipes} exact/>
      <Route path = '/profile' component={Profile} exact/>
      <Route path = '/aboutus' component={AboutUs} exact/>
      </Switch>
    </div>
    
  );
}


export default App;
