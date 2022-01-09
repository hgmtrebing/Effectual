const React = require('react');
const ReactDOM = require('react-dom')
const axios = require('axios');

export default class DevAdminAllUsers extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            errorRetrievingData: false,
            dataLoaded: false,
            users: []
        }

    }

    componentDidMount() {
        const screen = this;
        axios.get("/dev/all-users")
            .then(function (response) {
                console.log(response);
                screen.setState({
                    errorRetrievingData: false,
                    dataLoaded: true,
                    users: response.data
                })
            })
            .catch(function(error) {
                console.log(error);
                screen.setState({
                    errorRetrievingData: true,
                    dataLoaded: false,
                    users: []
                })
            })
            .then(function() {

            });
    }

    render() {
        const {errorRetrievingData, dataLoaded, users} = this.state;

        if (errorRetrievingData) {
            return <div> Error retrieving user data from the Server! </div>

        } else if (!dataLoaded) {
            return <div> Loading ... </div>

        } else {
            return (
            <div className={"container"}>
                <h1>System Users</h1>
                    {users.map(user => (
                        <div className={"card"} key={user.id}>
                            <div className={"card-body"}>
                                <div className={"card-title"}> {user.lastName}, {user.firstName}</div>
                                <ul className={"list-group"}>
                                    <li className={"list-group-item"}>Username: {user.username}</li>
                                    <li className={"list-group-item"}>Email Address: {user.emailAddress}</li>
                                    <li className={"list-group-item"}>Create Date: {user.createDate}</li>
                                    <li className={"list-group-item"}>Last Modified Date: {user.lastModifiedDate}</li>
                                    <li className={"list-group-item"}>Last Login Date: {user.lastLoginDate}</li>
                                </ul>
                            </div>

                        </div>

                    ))}
            </div>
            );
        }
    }
}
