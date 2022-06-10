import React from 'react';


 export default function Contact(props) { 
//export default function Contact({img, name, phone, email}) {
    //console.log(img, name, phone, email)
    return (
        <div className="contacts">
            <div className="contact-card">
                <img src={props.img} alt="cat" />
                <h3>{props.name}</h3>
                {/* <img src={img} />
                <h3>{name}</h3>*/ }
                <div className="info-group">
                    <i className="fa-solid fa-phone"></i>
                   <p>{props.phone}</p>
                   {/*<p>{phone}</p> */}
                </div>
                <div className="info-group">
                    <i className="fa-solid fa-envelope"></i>
                    <p>{props.email}</p>
                {/* <p>{email}</p> */}
                </div>
            </div>
            
        </div>
    )
}

