// import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout"
import ErrorPage from "./pages/ErrorPage";
import Categories from "./pages/Categories";

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Layout />}>
                <Route index element={<Categories/>} />
                <Route path={"*"} element={<ErrorPage errorMessage='Error 404: Page Not Found!'/>}/>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
