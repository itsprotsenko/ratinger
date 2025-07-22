import style from "../css/Categories.css"
import ErrorPage from "./ErrorPage";
import {useState, useEffect} from "react";
import loadingIcon from '../resources/loading-icon.png'

const ratingerAPIUrl = 'http://localhost:8080'


function Categories() {

    const [categories, setCategories] = useState([]);
    const [categoriesReceived, setCategoriesReceived] = useState(false);
    const [errorResponse, setErrorResponse] = useState('')
    const [errorStatus, setErrorStatus] = useState(400)

    useEffect(() => {
        fetch(ratingerAPIUrl + '/category/get/all')
            .then(response => {
                if(!response.ok) {
                    setErrorStatus(response.status)
                    return response.json().then(error => {
                        console.log(error)
                        throw Error(`${error.message}`)
                    })
                }

                console.log(response)
                return response.json()
            })
            .then(data => {
                setCategories(data)
                console.log(data)
                setCategoriesReceived(true)
            })
            .catch(error => {
                setErrorResponse(error.message)
                // console.log(error)
                setCategoriesReceived(true)
            })
    }, []);


    if(!categoriesReceived) {
        return (
            <div className={'loading-icon_div'}>
                <img src={loadingIcon}  className={'loading-icon_img'} alt={'loading...'}/>
            </div>
        )
    }
    if(errorResponse !== '') {
        return (
            <div>
                <ErrorPage errorMessage={`Error ${errorStatus}: ${errorResponse}`}/>
            </div>
        )
    }
    return (
        <div>
            {categories.map((category) => (
                <div className={'category_div'} key={category.id} style={{backgroundColor: category.color}}>
                    <p className={'category-name'}>{category.name}</p>
                    <p className={'category-description'}>{category.description}</p>
                </div>
            ))}
        </div>
    )
}

export default Categories