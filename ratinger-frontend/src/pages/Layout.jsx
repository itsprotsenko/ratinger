import {Link, Outlet} from "react-router-dom";
import style from "../css/Layout.css";

function Layout() {
    return (
        <>
            <nav className={"navbar_nav"}>
                <ul>
                    <li className={"navbar_li"}>
                        <Link to="/" className={"navbar-link"}>Home</Link>
                    </li>
                </ul>
            </nav>
            <Outlet />
        </>
    )
}

export default Layout;