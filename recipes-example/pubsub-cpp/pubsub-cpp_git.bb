DESCRIPTION = "PubSub cpp example"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/documents/LICENSE;md5=f91e61641e7a96835dea6926a65f4702"

SRC_URI = "git://github.com/aws/aws-iot-device-sdk-cpp-v2.git;protocol=https;branch="main" \
           file://0001-main.cpp-fix-building-with-gcc12.patch;striplevel=4"

SRCREV = "07adffcb3a1a0184849232315744edc9aef3ab93"

S = "${WORKDIR}/git/samples/pub_sub/basic_pub_sub"

inherit cmake

DEPENDS = "aws-c-iot"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

do_install() {
  install -d ${D}${base_sbindir} 
  install -m 0755 ${WORKDIR}/build/basic-pub-sub ${D}${base_sbindir}/basic-pub-sub
}