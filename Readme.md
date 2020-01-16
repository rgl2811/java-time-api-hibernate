DB DDL

```
CREATE TABLE `tzentity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created_local_date` date DEFAULT NULL,
  `date_created_local_date_time` datetime(3) DEFAULT NULL,
  `date_created_offset_date_time` datetime(3) DEFAULT NULL,
  `date_offset` datetime(3) DEFAULT NULL,
  `duration` bigint(20) DEFAULT NULL,
  `instant` datetime(3) DEFAULT NULL,
  `zoned_date_time_america` datetime(3) DEFAULT NULL,
  `zoned_date_time_local` datetime(3) DEFAULT NULL,
  `date_offset_local` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
```

Create TZ Entity

```
curl -vXPOST localhost:8080/entities
```

Retrieve TZ Entity

```
curl -vXGET localhost:8080/entities/3
```

