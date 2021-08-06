<?xml version="1.0" encoding="ISO-8859-9"?>

<MyPersons>
    <personGroup>Employee</personGroup>
    <#list personList as person>
        <person>
            <name>Person name: ${person.name}</name>
            <surname>Person surname: ${person.surName}</surname>
            <age>Person age: ${person.age}</age>
        </person>
    </#list>
</MyPersons>