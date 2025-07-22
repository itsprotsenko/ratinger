import style from "../css/ErrorPage.css"

function ErrorPage(props) {
    return (
        <div className={"error-msg_div"}>
            <h2 className={"error-msg_p2"}>{props.errorMessage}</h2>
        </div>
    )
}

export default ErrorPage;