const React = require('react');
const ReactDOM = require('react-dom');
import DevAdminAllUsers from "./dev-admin-all-users";

/* Test */
class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tasks: [],
            projects: []
        }
    }

    componentDidMount() {
    }

    render() {
        return (
            <div>
                <DevAdminAllUsers/>
            </div>
        )
    }
}

ReactDOM.render(
    <p>testrndr</p>,
    document.getElementById('react')
)