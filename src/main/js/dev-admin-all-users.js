const React = require('react');
const ReactDOM = require('react-dom')
const axios = require('axios');

export default class DevAdminAllUsers extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        axios.get("/dev/all-users")
            .then(function (response) {
                console.log(response);
            })
            .catch(function(error) {
                console.log(error);
            })
            .then(function() {

            });
    }

    render() {
        return (
            <p>
                dev admin test
            </p>
        );
    }
}
