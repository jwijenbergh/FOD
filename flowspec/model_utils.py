# -*- coding: utf-8 -*- vim:fileencoding=utf-8:
# vim: tabstop=4:shiftwidth=4:softtabstop=4:expandtab

import logging
FORMAT = '%(asctime)s %(levelname)s: %(message)s'
logging.basicConfig(format=FORMAT)
logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)

#############################################################################
#############################################################################
# global helpers 

# class1's attribute 'id' should be existing and be the primary key, e.g., be a Django model class
def convert_container_to_queryset(list1, class1):
         #temp1_ids = [obj.id for obj in list1]
         temp1_ids = [obj.id for obj in list1 if obj != None]
         temp2_ids = set(temp1_ids)
         return class1.objects.filter(id__in=temp2_ids)

#############################################################################
#############################################################################

