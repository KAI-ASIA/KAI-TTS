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

 Date: 07/01/2025 21:52:30
*/


-- ----------------------------
-- Table structure for request_out
-- ----------------------------
DROP TABLE IF EXISTS "t24_util"."request_out";
CREATE TABLE "t24_util"."request_out" (
  "req_id" varchar COLLATE "pg_catalog"."default" NOT NULL,
  "receive_time" timestamp(0),
  "response_time" timestamp(0),
  "request_msg" text COLLATE "pg_catalog"."default",
  "response_msg" text COLLATE "pg_catalog"."default",
  "request_api" varchar(255) COLLATE "pg_catalog"."default",
  "request_node" varchar(255) COLLATE "pg_catalog"."default",
  "process_node" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(255) COLLATE "pg_catalog"."default",
  "end_process_time" timestamp(0),
  "start_process_time" timestamp(0),
  "response_node" varchar(255) COLLATE "pg_catalog"."default",
  "receive_node" varchar(255) COLLATE "pg_catalog"."default",
  "id" int8 NOT NULL DEFAULT nextval('"t24_util".request_out_id_seq'::regclass)
)
;

-- ----------------------------
-- Primary Key structure for table request_out
-- ----------------------------
ALTER TABLE "t24_util"."request_out" ADD CONSTRAINT "request_out_pkey" PRIMARY KEY ("req_id");
