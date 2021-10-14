import logo from './logo.svg';
import './App.css';
import { Route, Switch } from 'react-router-dom';
import home from './Pages/home';
import searchingredient from './Pages/searchingredient';
import Search from './Components/search';
import findrecipes from './Pages/findrecipes';
import signup from './Pages/signup';
import profile from './Pages/profile';


function App() {
  return (
    <div className="App">
      <Switch>
      <Route path = '/'  component={home} exact/>
      <Route path ='/searchingredient' component={searchingredient} exact/>
      <Route path ='/findrecipes' component={findrecipes} exact/>
      <Route path ='/signup' component={signup} exact/>
      <privateRoute path = '/profile' component={profile} exact/>
      </Switch>
      {/* <Search /> */}
    </div>
    
  );
}


export default App;
