/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 120013
 Source Host           : localhost:5432
 Source Catalog        : KAI
 Source Schema         : t24_util

 Target Server Type    : PostgreSQL
 Target Server Version : 120013
 File Encoding         : 65001

 Date: 07/01/2025 21:50:54
*/


-- ----------------------------
-- Table structure for request_in
-- ----------------------------
DROP TABLE IF EXISTS "request_in";
CREATE TABLE "request_in" (
  "req_id" varchar COLLATE "pg_catalog"."default" NOT NULL,
  "priority" int4,
  "receive_time" timestamp(0),
  "request_msg" text COLLATE "pg_catalog"."default",
  "request_api" varchar(255) COLLATE "pg_catalog"."default",
  "request_node" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(255) COLLATE "pg_catalog"."default",
  "timeout" int4,
  "authen_type" varchar(255) COLLATE "pg_catalog"."default",
  "id" int8 NOT NULL DEFAULT nextval('"t24_util".request_in_id_seq'::regclass)
)
;

-- ----------------------------
-- Primary Key structure for table request_in
-- ----------------------------
ALTER TABLE "request_in" ADD CONSTRAINT "request_in_pkey" PRIMARY KEY ("req_id");
