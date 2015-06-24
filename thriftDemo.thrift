namespace cpp thriftDemo
namespace java thriftDemo
namespace php thriftDemo

struct User {
	1: required string username;
	2: optional string userIP;
}

struct ServerManager {
	1: required i32 totalAccessCounter;
	2: required map<string, i32> userAccessCounter;
}

service APIs {
	bool put(1: string _username, 2: i32 _newValue),
	bool increase(1: string _username),
	i32 get(1: string _username),
	bool ping()
}
