fn get_group_purls_stage_equivalent() -> Stage {

    let mut purl_map = Map::new();
    purl_map.insert(
        String::from("purl"),
        Value::String(String::from("$purl")),
    );

    let mut push_map = Map::new();
    push_map.insert(
        String::from("$push"),
        Value::Object(purl_map),
    );

    let mut group_value = Map::new();
    group_value.insert(
        String::from("purls"),
        Value::Object(push_map),
    );

    group_value.insert(
        String::from("_id"),
        Value::String(String::from("")),
    );

    let mut group_map = Map::new();
    group_map.insert(
        String::from("$group"),
        Value::Object(group_value),
    );


    Stage::new(Value::Object(group_map))
}
